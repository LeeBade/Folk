package com.titian.server;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.HashMap;
import java.io.File;
import java.util.UUID;

@RestController
public class controller {
    @Value("${SavePath.ProfilePhoto}")
    private String ProfilePhotoSavePath;   //图标图片存储路径
    @Value("${SavePath.ProfilePhotoMapper}")
    private String ProfilePhotoMapperPath;   //图标映射路径
    @Autowired
    private JdbcTemplate jdbcTemplate;
    /**
     * @param image 图片资源
     * @return 图映射的虚拟访问路径
     */
    @PostMapping("/image")
    public HashMap<String,Object> profilePhotoUpload(@RequestBody MultipartFile image){
        //获取文件名
        String fileName = image.getOriginalFilename();
        //获取文件后缀名。也可以在这里添加判断语句，规定特定格式的图片才能上传，否则拒绝保存。
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //为了避免发生图片替换，这里使用了文件名重新生成
        fileName = UUID.randomUUID()+suffixName;
        HashMap<String,Object> map=new HashMap<>();
        try {
            //将图片保存到文件夹里
            image.transferTo(new File (ProfilePhotoSavePath+fileName));
            map.put ("url",ProfilePhotoMapperPath+fileName);
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put ("err","error");
            return map;
        }
    }

    @PostMapping("/text")
    public HashMap<String, Object> uploadText(@RequestBody TextRequest request) {
        int id = request.getId();
        String content = request.getContent();

        // 检查记录是否存在
        String sqlSelect = "SELECT COUNT(*) FROM content WHERE id = ?";
        int count = jdbcTemplate.queryForObject(sqlSelect, Integer.class, id);

        if (count > 0) {
            // 如果记录存在，则执行更新操作
            String sqlUpdate = "UPDATE content SET content = ? WHERE id = ?";
            jdbcTemplate.update(sqlUpdate, content, id);

            HashMap<String, Object> response = new HashMap<>();
            response.put("msg", "修改成功");
            response.put("code", 200);
            return response;
        } else {
            // 如果记录不存在，则执行插入操作
            String sqlInsert = "INSERT INTO content (id, content) VALUES (?, ?)";
            jdbcTemplate.update(sqlInsert, id, content);

            HashMap<String, Object> response = new HashMap<>();
            response.put("msg", "上传成功");
            response.put("code", 200);
            return response;
        }
    }


    @GetMapping("/text")
    public HashMap<String, Object> getTextById(@RequestParam("id") int id) {
        String sql = "SELECT content FROM content WHERE id = ?";
        String content = jdbcTemplate.queryForObject(sql, String.class, id);

        HashMap<String, Object> response = new HashMap<>();
        response.put("text", content);
        return response;
    }

}
