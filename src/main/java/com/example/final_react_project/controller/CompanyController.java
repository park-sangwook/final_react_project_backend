package com.example.final_react_project.controller;

import com.example.final_react_project.dto.CompanyDTO;
import com.example.final_react_project.dto.MenuDTO;
import com.example.final_react_project.dto.OrderedDTO;
import com.example.final_react_project.security.PrincipalDetails;
import com.example.final_react_project.service.CompanyService;
import com.example.final_react_project.service.MenuService;
import com.example.final_react_project.service.OrderedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CompanyController {
    private final CompanyService companyService;
    private final MenuService menuService;
    private final OrderedService orderedService;

    @GetMapping(value = "/category/{idx}")
    public ResponseEntity<?> categoryIdx(@PathVariable int idx){
        List<CompanyDTO> dto = null;
        if(idx==0){
            dto = companyService.selectAll();
        }else{
            dto = companyService.selectAllByIdx(idx);
        }
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }

    // 회사 별 메뉴
    @GetMapping(value = "/restaurant/selectAll/{idx}")
    public ResponseEntity<?> selectAll(@PathVariable int idx){
        return ResponseEntity.status(HttpStatus.OK).body(companyService.selectByIdx(idx));
    }

    // 메뉴 개별 보기
    @GetMapping(value = "/restaurant/selectByIdx/{idx}")
    public ResponseEntity<?> selectByIdxMenu(@PathVariable int idx){
        return ResponseEntity.status(HttpStatus.OK).body(menuService.selectByIdx(idx));
    }

    // 주문
    @PostMapping(value = "/payOk")
    public ResponseEntity<?> payOk(@RequestBody List<OrderedDTO> dto,@AuthenticationPrincipal PrincipalDetails principalDetails){
        System.out.println("결과 user-info : "+principalDetails.getDto());
        for (OrderedDTO orderedDTO : dto) {
            orderedDTO.setMenu_idx(orderedDTO.getIdx());
            orderedDTO.setLogin_id(principalDetails.getDto().getId());
            orderedService.insert(orderedDTO);

        }
        return ResponseEntity.status(HttpStatus.OK).body("결제완료");
    }
}
