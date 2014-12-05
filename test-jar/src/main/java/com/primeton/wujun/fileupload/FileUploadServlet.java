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
 * 文件上传 servlet
 * 详尽注释每一步做法和含义,方便大家学习
 * 
 * @version 1.0
 * @author caohua
 * @company 传智博客 
 */
public class FileUploadServlet extends HttpServlet {

    /**
     * 序列化servlet，防止钝化后无法恢复的问题
     */
    private static final long serialVersionUID = 1L;

    public FileUploadServlet() {
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=gb2312");//设置返回头信息
        PrintWriter out = response.getWriter();//返回的输出
        
        String path = getServletContext().getRealPath("/upload");//得到该应用下的upload目录在服务器上的绝对路径
    
        if( path == null ){//如果为空表示不能访问，可能是系统设置了访问权限
            out.print("无法访问该目录！");
            return;
        }
        
        File uploadDir = new File(path);//得到该目录的文件对象
        
        if(!uploadDir.exists()){//判断该目录是否存在
            
            if(!uploadDir.mkdir()){//如果不存在就建立该目录
                out.print("无法创建该目录！");//如果建立失败，给出提示
                return;
            }
        }
        
        if(!ServletFileUpload.isMultipartContent(request)){//用 ServletFileUpload 类的静态方法 isMultipartContent 判断 request 是否是 multipart/form-data 类型
            out.print("只能 multipart/form-data 类型数据");
            return;
        }
        //创建 DiskFileItemFactory 对象
        DiskFileItemFactory factory = new DiskFileItemFactory();
        
        //factory.setRepository(tempDir);可以设置缓存目录
        factory.setSizeThreshold(1024 * 1024);//超过1m的数据采用临时文件缓存
        
        ServletFileUpload upload = new ServletFileUpload(factory);//创建 ServletFileUpload 对象，构造的时候传一个 DiskFileItemFactory 对象进去
        upload.setFileSizeMax(1024 * 1024 * 2);//单个文件大小
        upload.setHeaderEncoding("gb2312");//设置普通字段名称和文件字段的文件名所采用的字符集编码
        upload.setSizeMax(1024 * 1024 * 4);//最多上传2m的文件
        
        List list = null;
        try {
            list = upload.parseRequest(request);//解析 request 对象 得到一个包含 FileItem 对象的 list
        } catch (FileUploadException e) {
            out.print("解析文件时出现问题：");
            e.printStackTrace();
            return;
        }
        
        Iterator it = list.iterator();//遍历list
        while(it.hasNext()){
            FileItem fi = (FileItem)it.next();//类型转换
            //for czc
            fi.getInputStream();
            fi.getOutputStream();
            if(fi.isFormField()){//判断该 FileItem 对象是否是一个普通表单类型
                String name = fi.getFieldName();//得到普通表单类型的表单名
                String content = fi.getString("GB2312");//用指定编码得到普通表单的值
                request.setAttribute(name, content);//把键值放入 request 对象
            }else{
                try{
                    String pathStr = fi.getName();//得到文件表单的值，就是用户本地的文件路径
                    //如果文件表单为空，则不处理
                    if(pathStr.trim().equals("")){
                        continue;
                    }
                    int start = pathStr.lastIndexOf("//");//得到文件名在路径中的位置
                    String fileName = pathStr.substring(start + 1);//得到文件名
                    
                    File pathDest = new File( path , fileName );//创建上传上来的文件对象  由服务器上存放文件的路径 + 文件名 组成
                    
                    fi.write(pathDest);//写文件
                    
                    String name = fi.getFieldName();//得到文件表单的名称
                    request.setAttribute(name, fileName);//把表单名、文件名放入 request
                    
                }catch(Exception e){
                    out.print("存储文件错误：");
                    e.printStackTrace();
                    return;
                }
                finally{//立即删除保存表单字段内容的临时文件
                    fi.delete();
                }
            }
        }
        
        StringBuffer filelist = new StringBuffer();//得到可变字符串对象
        
        //把上传的文件名拼装到可变字符串中
        String file1 = (String)request.getAttribute("file1");
        makeUplist(filelist, file1);
        String file2 = (String)request.getAttribute("file2");
        makeUplist(filelist, file2);
        
        request.setAttribute("list", filelist);//把文件名的字符串放入 request
        request.getRequestDispatcher("success.jsp").forward(request, response);//请求转发到指定页面
        
    }
    /**
     * 将 str 追加到 sb中，以“,”隔开 
     * @param sb
     * @param str
     */
    private void makeUplist(StringBuffer sb ,String str){
        
        if(str != null){//追加的字符串为空则不做任何操作
            if(sb.length() != 0){//如果可变字符串长度不为0，需要用“,”隔开
                sb.append(",");
            }
            sb.append(str);//追加字符串
        }
        
    }

    public void init() throws ServletException {
    }

}
