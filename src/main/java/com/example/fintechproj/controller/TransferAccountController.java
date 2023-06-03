package com.example.fintechproj.controller;

import com.example.fintechproj.domain.form.TransferForm;

import com.example.fintechproj.exception.ErrorCode;
import com.example.fintechproj.exception.UserException;
import com.example.fintechproj.service.TransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transfer")
@RequiredArgsConstructor
public class TransferAccountController {

    private final TransferService transferService;
    @PostMapping("/account")
    public ResponseEntity<String> transferAccountControl(@RequestBody TransferForm form){
        return ResponseEntity.ok(transferService.transferAccountSer(form));
    }
    @GetMapping("/search")
    public ResponseEntity<List<String>> searchTransferAccountControl(@RequestParam String accountNum){
        List<String> lst = transferService.searchTransferAccountSer(accountNum);
        if(lst.isEmpty()){
            throw new UserException(ErrorCode.NULL_DATA_TRANSFER);
        }else{
            return ResponseEntity.ok(lst);
        }
    }
}
