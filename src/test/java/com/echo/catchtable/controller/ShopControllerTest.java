package com.echo.catchtable.controller;

import com.echo.catchtable.domain.Shop;
import com.echo.catchtable.domain.WaitingInformation;
import com.echo.catchtable.dto.request.ShopSaveRequest;
import com.echo.catchtable.repository.ReservationInformationRepository;
import com.echo.catchtable.repository.ShopRepository;
import com.echo.catchtable.repository.WaitingInformationRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ShopControllerTest {
    @Autowired
    protected MockMvc mockMvc;
    @Autowired
    protected ObjectMapper objectMapper;
    @Autowired
    private WebApplicationContext context;
    @Autowired
    ShopRepository shopRepository;
    @Autowired
    WaitingInformationRepository wInfoRepository;
    @Autowired
    ReservationInformationRepository rInfoRepository;

    @BeforeEach
    public void mockMvcSetUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
        shopRepository.deleteAll();
        wInfoRepository.deleteAll();
        rInfoRepository.deleteAll();
    }

    @DisplayName("ShopSave: 상점 등록 테스트")
    @Test
    public void ShopSave() throws Exception {
        String filePath = "src/test/resources/json/shop/registerRequest.json"; // resources 폴더 내의 파일 경로
        final String url = "/shops";
        final String request = new String(Files.readAllBytes(Paths.get(filePath)));

        ResultActions result = mockMvc.perform(post(url).contentType(MediaType.APPLICATION_JSON_VALUE).content(request));

        result.andExpect(status().isCreated());

        // shop db에 저장되었는지 확인
        List<Shop> shops = shopRepository.findAll();
        assertThat(shops.size()).isEqualTo(1);
        assertThat(shops.get(0).getSellerId()).isEqualTo(111);

        // waitingInformation db에 저장되었는지 확인
        List<WaitingInformation> wInfos = wInfoRepository.findAll();
        assertThat(wInfos.size()).isEqualTo(1);
        assertThat(wInfos.get(0).getShopId()).isEqualTo(shops.get(0).getId());

        // reservationInformation db에 저장되었는지 확인
        List<WaitingInformation> rInfos = wInfoRepository.findAll();
        assertThat(rInfos.size()).isEqualTo(1);
        assertThat(rInfos.get(0).getShopId()).isEqualTo(shops.get(0).getId());

        // 결과가 제대로 나왔는지 확인
        result
            .andExpect(jsonPath("$.name").value("제로베이스 2호점"))
            .andExpect(jsonPath("$.seller_id").value(111));
    }
}