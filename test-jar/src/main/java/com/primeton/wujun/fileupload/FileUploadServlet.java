package com.primeton.wujun.fileupload;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * �ļ��ϴ� servlet
 * �꾡ע��ÿһ�������ͺ���,������ѧϰ
 * 
 * @version 1.0
 * @author caohua
 * @company ���ǲ��� 
 */
public class FileUploadServlet extends HttpServlet {

    /**
     * ���л�servlet����ֹ�ۻ����޷��ָ�������
     */
    private static final long serialVersionUID = 1L;

    public FileUploadServlet() {
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=gb2312");//���÷���ͷ��Ϣ
        PrintWriter out = response.getWriter();//���ص����
        
        String path = getServletContext().getRealPath("/upload");//�õ���Ӧ���µ�uploadĿ¼�ڷ������ϵľ���·��
    
        if( path == null ){//���Ϊ�ձ�ʾ���ܷ��ʣ�������ϵͳ�����˷���Ȩ��
            out.print("�޷����ʸ�Ŀ¼��");
            return;
        }
        
        File uploadDir = new File(path);//�õ���Ŀ¼���ļ�����
        
        if(!uploadDir.exists()){//�жϸ�Ŀ¼�Ƿ����
            
            if(!uploadDir.mkdir()){//��������ھͽ�����Ŀ¼
                out.print("�޷�������Ŀ¼��");//�������ʧ�ܣ�������ʾ
                return;
            }
        }
        
        if(!ServletFileUpload.isMultipartContent(request)){//�� ServletFileUpload ��ľ�̬���� isMultipartContent �ж� request �Ƿ��� multipart/form-data ����
            out.print("ֻ�� multipart/form-data ��������");
            return;
        }
        //���� DiskFileItemFactory ����
        DiskFileItemFactory factory = new DiskFileItemFactory();
        
        //factory.setRepository(tempDir);�������û���Ŀ¼
        factory.setSizeThreshold(1024 * 1024);//����1m�����ݲ�����ʱ�ļ�����
        
        ServletFileUpload upload = new ServletFileUpload(factory);//���� ServletFileUpload ���󣬹����ʱ��һ�� DiskFileItemFactory �����ȥ
        upload.setFileSizeMax(1024 * 1024 * 2);//�����ļ���С
        upload.setHeaderEncoding("gb2312");//������ͨ�ֶ����ƺ��ļ��ֶε��ļ��������õ��ַ�������
        upload.setSizeMax(1024 * 1024 * 4);//����ϴ�2m���ļ�
        
        List list = null;
        try {
            list = upload.parseRequest(request);//���� request ���� �õ�һ������ FileItem ����� list
        } catch (FileUploadException e) {
            out.print("�����ļ�ʱ�������⣺");
            e.printStackTrace();
            return;
        }
        
        Iterator it = list.iterator();//����list
        while(it.hasNext()){
            FileItem fi = (FileItem)it.next();//����ת��
            //for czc
            fi.getInputStream();
            fi.getOutputStream();
            if(fi.isFormField()){//�жϸ� FileItem �����Ƿ���һ����ͨ������
                String name = fi.getFieldName();//�õ���ͨ�����͵ı���
                String content = fi.getString("GB2312");//��ָ������õ���ͨ����ֵ
                request.setAttribute(name, content);//�Ѽ�ֵ���� request ����
            }else{
                try{
                    String pathStr = fi.getName();//�õ��ļ�����ֵ�������û����ص��ļ�·��
                    //����ļ���Ϊ�գ��򲻴���
                    if(pathStr.trim().equals("")){
                        continue;
                    }
                    int start = pathStr.lastIndexOf("//");//�õ��ļ�����·���е�λ��
                    String fileName = pathStr.substring(start + 1);//�õ��ļ���
                    
                    File pathDest = new File( path , fileName );//�����ϴ��������ļ�����  �ɷ������ϴ���ļ���·�� + �ļ��� ���
                    
                    fi.write(pathDest);//д�ļ�
                    
                    String name = fi.getFieldName();//�õ��ļ���������
                    request.setAttribute(name, fileName);//�ѱ������ļ������� request
                    
                }catch(Exception e){
                    out.print("�洢�ļ�����");
                    e.printStackTrace();
                    return;
                }
                finally{//����ɾ��������ֶ����ݵ���ʱ�ļ�
                    fi.delete();
                }
            }
        }
        
        StringBuffer filelist = new StringBuffer();//�õ��ɱ��ַ�������
        
        //���ϴ����ļ���ƴװ���ɱ��ַ�����
        String file1 = (String)request.getAttribute("file1");
        makeUplist(filelist, file1);
        String file2 = (String)request.getAttribute("file2");
        makeUplist(filelist, file2);
        
        request.setAttribute("list", filelist);//���ļ������ַ������� request
        request.getRequestDispatcher("success.jsp").forward(request, response);//����ת����ָ��ҳ��
        
    }
    /**
     * �� str ׷�ӵ� sb�У��ԡ�,������ 
     * @param sb
     * @param str
     */
    private void makeUplist(StringBuffer sb ,String str){
        
        if(str != null){//׷�ӵ��ַ���Ϊ�������κβ���
            if(sb.length() != 0){//����ɱ��ַ������Ȳ�Ϊ0����Ҫ�á�,������
                sb.append(",");
            }
            sb.append(str);//׷���ַ���
        }
        
    }

    public void init() throws ServletException {
    }

}
