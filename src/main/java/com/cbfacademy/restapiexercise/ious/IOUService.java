package com.cbfacademy.restapiexercise.ious;

import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

@Service
public class IOUService {

    @Autowired
    private IOURepository iouRepository;

    public List<IOU> getAllIOUs() {
        return iouRepository.findAll();
    }

    public IOU getIOU(UUID id) throws NoSuchElementException{
        return iouRepository.findById(id).orElseThrow(() -> new NoSuchElementException(id + "not found"));
    }

    public IOU createIOU(IOU iou) throws IllegalArgumentException, OptimisticLockingFailureException {
        return iouRepository.save(iou);
    }

    public IOU updateIOU(UUID id, IOU updatedIOU) throws NoSuchElementException {
        IOU existingIOU = iouRepository.findById(id).orElseThrow(() -> new NoSuchElementException( id + "not found"));
        return iouRepository.save(existingIOU);
    }

    public void deleteIOU(UUID id) {
        iouRepository.deleteById(id);
    }

    public List<IOU> getIOUsByBorrower(String borrower) {
        return iouRepository.findByBorrower(borrower);
    }

    public List<IOU> getHighValueIous() {

        return iouRepository.findHighValueIOUs();
    }

    public List<IOU> getLowValueIous() {

        return iouRepository.findLowValueIous();
    }
}
