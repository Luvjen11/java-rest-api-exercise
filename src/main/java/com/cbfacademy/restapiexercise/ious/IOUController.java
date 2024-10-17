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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ious")
public class IOUController {
    @Autowired
    private IOUService iouService;

    @GetMapping
    public List<IOU> getIOUs(@RequestParam(required = false) String borrower){
        if (borrower != null) {
            return iouService.getIOUsByBorrower(borrower);  // Get IOUs by borrower
        }
        return iouService.getAllIOUs(); // Get all IOUs if no borrower specified
    }

    @GetMapping("/{id}")
    public IOU getIOUsById(@PathVariable UUID id){
        return iouService.getIOU(id);
    }

    @PostMapping
    public IOU createIOUs(@RequestBody IOU iou){
        return iouService.createIOU(iou);
    }

    @PutMapping("/{id}")
    public IOU updateIOUs(@PathVariable UUID id, @RequestBody IOU iou){
        return iouService.updateIOU(id, iou);
    }

    @DeleteMapping("/{id}")
    public void deleteIOUs(@PathVariable UUID id){
        iouService.deleteIOU(id);
    }

    @GetMapping("/high")
    public List<IOU> getHighValueIous() {
         return iouService.getHighValueIous();
    }
    
}
