package com.cbfacademy.restapiexercise.ious;

import java.util.UUID;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


public class IOUController {
    @Autowired
    private IOUService iouService;

    @GetMapping("/api/ious")
    public List<IOU> getIOUs(){
        return iouService.getAllIOUs();
    }

    @GetMapping("/api/ious/{id}")
    public IOU getIOUsById(@PathVariable UUID id){
        return iouService.getIOU(id);
    }

    @PostMapping("/api/ious")
    public IOU createIOUs(@RequestBody IOU iou){
        return iouService.createIOU(iou);
    }

    @PutMapping("/api/ious/{id}")
    public IOU updateIOUs(@PathVariable UUID id, @RequestBody IOU iou){
        return iouService.updateIOU(id, iou);
    }

    @DeleteMapping("/api/ious/{id}")
    public void deleteIOUs(@PathVariable UUID id){
        iouService.deleteIOU(id);
    }
}
