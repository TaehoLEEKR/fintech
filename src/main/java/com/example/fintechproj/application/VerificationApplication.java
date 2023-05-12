package com.example.fintechproj.application;

import com.example.fintechproj.domain.model.User;
import com.example.fintechproj.domain.repository.UserRepository;
import com.example.fintechproj.exception.ErrorCode;
import com.example.fintechproj.exception.UserException;
import com.example.fintechproj.service.VerificationSignUpService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VerificationApplication {
    private final VerificationSignUpService verificationSignUpService;
    private final UserRepository userRepository;


    public boolean isEmailExist(String email){
        return userRepository.findByUserEmail(email.toLowerCase(Locale.ROOT)).isPresent();
    }

    public String getRendomCode() {
        // 랜덤 코드 생성
        return RandomStringUtils.random(10,true,true);
    }

    @Transactional
    public void isVerifyEmail(String email , String code){
        // 이메일 인증 링크 접속시
        User user = userRepository.findByUserEmail(email).orElseThrow(()->new UserException(ErrorCode.NOT_FOUND_EMAIL));
        // 이메일 불일치시 에러
        if (user.isEmailVerified()){
            // 이미 인증된 상태이면 에러
            throw new UserException(ErrorCode.ALREADY_EMAIL_VERIFY);
        }else if(!user.getEmailVerificationCode().equals(code)){
            // 인증코드 불일치시 에러
            throw new UserException(ErrorCode.WRONG_VERIFICATION_CODE);
        }else if(user.getVerificationDt().isBefore(LocalDateTime.now())){
            // 인증코드 유효기간 1일 만료시 에러
            throw new UserException(ErrorCode.EXPIRE_CODE);
        }else{
            // 통과 시 True
            user.setEmailVerified(true);
        }
    }
    public String getVerificationEmailBody(String email ,String name,String code){
        //  인증 이메일 전송
        StringBuilder builder = new StringBuilder();
        return builder.append("Hello").append(name).append("! Please Click Link for verificaiton.\n\n")
                .append("http://localhost:8081/signup/user/?email=")
                .append(email)
                .append("&code")
                .append(code).toString();
    }
    @Transactional
    public LocalDateTime ChangePartnerValidateEmail(Long userId , String code){
        // 파트너 점장의 전달 받은 CODE 를 DB에 저장 하고 저장된 유효기간을 1일로 지정
        Optional<User> customerOptional = userRepository.findById(userId);
        if(customerOptional.isPresent()){
            User user = customerOptional.get();
            user.setEmailVerificationCode(code);
            user.setVerificationDt(LocalDateTime.now().plusDays(1));
            return user.getVerificationDt();
        }
        throw new UserException(ErrorCode.NOT_FOUND_EMAIL);
    }

}
