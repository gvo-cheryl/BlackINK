package com.semi.tattoo.image.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.api.client.json.Json;
import com.google.cloud.vision.v1.AnnotateImageRequest;
import com.google.cloud.vision.v1.AnnotateImageResponse;
import com.google.cloud.vision.v1.BatchAnnotateImagesResponse;
import com.google.cloud.vision.v1.EntityAnnotation;
import com.google.cloud.vision.v1.Feature;
import com.google.cloud.vision.v1.Image;
import com.google.cloud.vision.v1.ImageAnnotatorClient;
import com.google.cloud.vision.v1.Feature.Type;
import com.google.protobuf.ByteString;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.semi.tattoo.image.biz.imageBiz;
import com.semi.tattoo.image.dto.imageDto;
import com.semi.tattoo.tag.biz.tagBiz;
import com.semi.tattoo.tag.dto.tagDto;
import com.semi.tattoo.tattooshare.biz.tattooshareBiz;
import com.semi.tattoo.tattooshare.dto.tattooshareDto;

import java.util.*;
import java.util.Date;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.text.SimpleDateFormat;

import com.semi.tattoo.image.biz.*;

@WebServlet("/visionController.do")
public class visionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		Date today = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");
		String newfileName = date.format(today) + " " +time.format(today);
		
		String filepath = "";
		String oldfileName = "";
		System.out.println(oldfileName);
		int maxSize = 1024 * 1024 * 5;
		String encType = "utf-8";
		String savefile = "saveForSearch";
		ServletContext scontext = getServletContext();
		filepath = scontext.getRealPath(savefile)+"";
		//파일경로는 추후 IP로 고정하여 사용할 예정 
		System.out.println(filepath);
		
		List<imageDto> filelist = new ArrayList<imageDto>();
		imageBiz biz = new imageBiz();
		imageDto dto = new imageDto();
		
		
		try {
			MultipartRequest multi = new MultipartRequest(request, filepath, maxSize, encType,
					new DefaultFileRenamePolicy());
			Enumeration<?> files = multi.getFileNames();
			
			while(files.hasMoreElements()) {
				
				String file1 = (String) files.nextElement();
				
				oldfileName = multi.getFilesystemName(file1);
				oldfileName = oldfileName.replaceAll(" ", "");
				System.out.println(oldfileName);
				
				if(oldfileName != null) {
					
					int i = -1;
					
					if((i = oldfileName.lastIndexOf(".")) != -1){//파일 확장자 위치 
						newfileName = newfileName + oldfileName.substring(i, oldfileName.length());// 현재 시간과 확장자
					}
					File oldfile = new File(filepath+ "/" + oldfileName);
					File newfile = new File(filepath+ "/" + newfileName);
					System.out.println("oldfile : "+oldfile);
					System.out.println("newfile : "+newfile);
					if(!oldfile.renameTo(newfile)) {//파일명 변경
						System.out.println("파일명 변경 실패");
					};
					
					dto.setMe_no(1);
					dto.setIm_filename(oldfileName);
					dto.setIm_servername(newfileName);
					dto.setIm_filepath(filepath);
					System.out.println(filepath);
					filelist.add(dto);
					
//					System.out.println("controller: "+dto.getIm_filename());
//					System.out.println("controller: "+dto.getIm_servername());
//					System.out.println("controller: "+dto.getIm_filepath());
					
				}

			}
			// image테이블 추가 
//			List<Integer> im_no_list = biz.insertImage(filelist);
//			int im_no = 0;
//			for(int i: im_no_list) {
//				im_no = i;
//			}
			
			// vision 호출
			String fullPath = filepath + "/" + newfileName;
			List<String> labelList = labelImage(fullPath);
			String textTag = detectText(fullPath); 
			//System.out.println(textTag);
			
			List<tagDto> tagList = new ArrayList<tagDto>();
			tagBiz tagbiz = new tagBiz();
			int count = 0;
			for(String label : labelList) {
				tagDto tagDto = new tagDto();
				//tagDto.setIm_no(im_no);
				tagDto.setTa_labeltag(label);
				tagDto.setTa_texttag(textTag);
				tagList.add(tagDto);	
//				System.out.println("tagDto_im_no : " +tagDto.getIm_no());
//				System.out.println("tagDto_ta_label : " +tagDto.getTa_labeltag());
//				System.out.println("tagDto_ta_text : " +tagDto.getTa_texttag());
//				
			}
			
			//tagbiz.insertTag(tagList);
			
			tattooshareBiz ts_biz = new tattooshareBiz();
			List<tattooshareDto> ts_List = ts_biz.selectVisionList(tagList);
			
//			for(tattooshareDto vision : ts_List) {
//				System.out.println("vision_im_no : " + vision.getIm_no());
//				System.out.println("vision_im_servername : " + vision.getIm_servername());
//			}
			
			JsonArray resultArray = new JsonArray();
			JsonArray tagArray = new JsonArray();
			
			for(tattooshareDto ts_dto : ts_List) {
				Gson gson = new Gson();
				String jsonString = gson.toJson(ts_dto);
				resultArray.add(JsonParser.parseString(jsonString));
			}
			
			for(String s: labelList) {
				Gson gson = new Gson();
				String jsonString = gson.toJson(s);
				tagArray.add(JsonParser.parseString(jsonString));
			}
			Gson gson = new Gson();
			String jsonString = gson.toJson(textTag);
			JsonElement text = JsonParser.parseString(jsonString);
						
			System.out.println(resultArray);
			JsonObject result = new JsonObject();
			result.add("result", resultArray);
			result.add("labelTag", tagArray);
			result.add("textTag", text);
			
			
			response.getWriter().append(result+"");
			
//			Map<String, List> tagList = new HashMap<String, List>();
//			tagList.put("labelList", labelList);
//			tagList.put("textList", textList);
//			// 해당 im_no찾아서 tag테이블 추가
//			//biz.selectOne(dto, tagList);
//			for(String key: tagList.keySet()) {
//				System.out.println(tagList.containsValue(labelList));
//				for(int i = 0; i<tagList.get(key).size(); i++ ) {
//					System.out.println(tagList.get(labelList).get(i));
//				}
//			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}


		// PrintWriter out = response.getWriter();
		// out.print(labelList);

	}

	public static List<String> labelImage(String fullPath) throws IOException {
		// Initialize client that will be used to send requests. This client only needs
		// to be created
		// once, and can be reused for multiple requests. After completing all of your
		// requests,
		// call the "close" method on the client to safely clean up any remaining
		// background resources.

		// 요청을 보내는 데 사용할 클라이언트를 초기화한다. 이 클라이언트는 생성만하면 되고, 여러 요청에 재사용 할 수 있다.
		// 모든 요청을 완료 한 후 클라이언트의 "close"메소드를 사용하여 나머지 백그라운드 리소스를 안전하게 정리한다.

		List<String> labelList = new ArrayList<>();

		try (ImageAnnotatorClient vision = ImageAnnotatorClient.create()) {
						
			// The path to the image file to annotate: 주석을 달 이미지 파일의 경로
			// Reads the image file into memory: 이미지 파일을 메모리로 읽는다.
			Path path = Paths.get(fullPath);
			byte[] data = Files.readAllBytes(path);
			ByteString imgBytes = ByteString.copyFrom(data);

			// Builds the image annotation request: 이미지 주석 요청을 작성
			List<AnnotateImageRequest> requests = new ArrayList<>();
			Image img = Image.newBuilder().setContent(imgBytes).build();
			Feature feat = Feature.newBuilder().setType(Type.LABEL_DETECTION).build();
			AnnotateImageRequest request = AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
			requests.add(request);

			// Performs label detection on the image file: 이미지 파일에서 레이블 감지를 수행
			BatchAnnotateImagesResponse response = vision.batchAnnotateImages(requests);
			List<AnnotateImageResponse> responses = response.getResponsesList();

			for (AnnotateImageResponse res : responses) {
				if (res.hasError()) {
					System.out.format("Error: %s%n", res.getError().getMessage());
					//return;
				}

				for (EntityAnnotation annotation : res.getLabelAnnotationsList()) {
					//System.out.println("라벨태그 : "+annotation.getDescription());
					if( !annotation.getDescription().equals("Tattoo") && !annotation.getDescription().equals("Temporary Tattoo")) {
						labelList.add(annotation.getDescription().toLowerCase());
					}
				}
			}
		}
		return labelList;
	}

	// Detects text in the specified image.
	public static String detectText(String fullPath) throws IOException {
		List<AnnotateImageRequest> requests = new ArrayList<>();

		ByteString imgBytes = ByteString.readFrom(new FileInputStream(fullPath));

		Image img = Image.newBuilder().setContent(imgBytes).build();
		Feature feat = Feature.newBuilder().setType(Feature.Type.TEXT_DETECTION).build();
		AnnotateImageRequest request = AnnotateImageRequest.newBuilder().addFeatures(feat).setImage(img).build();
		requests.add(request);

		// Initialize client that will be used to send requests. This client only needs
		// to be created
		// once, and can be reused for multiple requests. After completing all of your
		// requests, call
		// the "close" method on the client to safely clean up any remaining background
		// resources.

		String textTag = "";

		try (ImageAnnotatorClient client = ImageAnnotatorClient.create()) {
			BatchAnnotateImagesResponse response = client.batchAnnotateImages(requests);
			List<AnnotateImageResponse> responses = response.getResponsesList();

			for (AnnotateImageResponse res : responses) {
				if (res.hasError()) {
					System.out.format("Error: %s%n", res.getError().getMessage());
					// return;
				}

				// For full list of available annotations, see http://g.co/cloud/vision/docs
				for (EntityAnnotation annotation : res.getTextAnnotationsList()) {
					if(textTag.contains(annotation.getDescription())) {
						
					} else if(annotation.getDescription().contains("\n")) {
						textTag += " " + annotation.getDescription().replaceAll("\n", " ");
					}
					
//					System.out.println(annotation.getDescription());
//					System.out.format("Text: %s%n", annotation.getDescription());
//					System.out.format("Position : %s%n", annotation.getBoundingPoly());
				}
			}	
		}
		textTag = textTag.trim().toLowerCase();
		if(textTag.equals("")) {
			textTag = "no texttag";
		}
		//System.out.println("text태그 : "+textTag);
		
		return textTag;
	}

	private void jsResponse(String msg, String url, HttpServletResponse response) throws IOException {
		String result = "<script> alert('" + msg + "'); location.href='" + url + "';</script>";
		response.getWriter().append(result);
	}

	private void dispatch(String path, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatch = request.getRequestDispatcher(path);
		dispatch.forward(request, response);
	}

}
