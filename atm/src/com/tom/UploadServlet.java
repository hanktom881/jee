package com.tom;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.apache.commons.io.FilenameUtils;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/upload")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		//
		ServletFileUpload upload = new ServletFileUpload();
		try {
			FileItemIterator items = upload.getItemIterator(request);
			while(items.hasNext()){
				FileItemStream item = items.next();
				if (item.isFormField()){
					InputStream is = item.openStream();
					String value = Streams.asString(is, "UTF-8");
					System.out.println(item.getFieldName()+":"+value);
				}else{
					String fileName = FilenameUtils.getName(item.getName());
					System.out.println("It's FILE!!:"+fileName);
					System.out.println(request.getServletContext().getRealPath("/"));
					String imagePath = request.getServletContext().getRealPath("/")+"images";
					File path = new File(imagePath);
					if (!path.exists()){
						path.mkdirs();
					}
					String fileType = fileName.substring(fileName.lastIndexOf(".")+1);
					fileName = new Date().getTime()+"."+fileType;
					File file = new File(path, fileName);
					BufferedInputStream bis = new BufferedInputStream(item.openStream());
					BufferedImage bImage = ImageIO.read(bis);
					ImageIO.write(bImage, fileType, file);
				}
			}
			
			
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}




