package com.example.fintechproj.service;

import com.example.fintechproj.application.VerificationApplication;
import com.example.fintechproj.client.MailgunClient;
import com.example.fintechproj.client.mailgun.SendMailForm;
import com.example.fintechproj.domain.form.SignUpForm;
import com.example.fintechproj.domain.model.User;
import com.example.fintechproj.domain.repository.UserRepository;
import com.example.fintechproj.exception.ErrorCode;
import com.example.fintechproj.exception.UserException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class VerificationSignUpService {

    private final UserRepository userRepository;
    private final VerificationApplication verificationApplication;
    private final MailgunClient mailgunClient;

    public void userVerify(String email ,String code){
        verificationApplication.isVerifyEmail(email,code);
    }
    public String verificationSignup(SignUpForm form){
        if(verificationApplication.isEmailExist(form.getUserEmail())) {
            // 회원가입 폼 작성시 이미 이메일 이 존재하면 에러 출력
            throw new UserException(ErrorCode.ALREADY_EMAIL);
        }else{
            // 이메일이 존재하지않다면 save
            User user = userRepository.save(User.from(form));
            String code = verificationApplication.getRendomCode();
            // 랜덤 인증 코드 생성
            // 이메일 인증
            SendMailForm  sendMailForm = SendMailForm.builder()
                    .from("679748@naver.com")
                    .to(form.getUserEmail())
                    .subjects("Verification Email")
                    .text(verificationApplication.getVerificationEmailBody(form.getUserEmail(), form.getUserName(), code))
                    // 이메일에 인증 GET주소를 전달 링크 클릭시 email & code 로 GET시도
                    .build();
            mailgunClient.sendEmail(sendMailForm);
            verificationApplication.ChangePartnerValidateEmail(user.getUserId(),code);

            return "회원가입 이메일을 전송 하였습니다.";
        }
    }
}
