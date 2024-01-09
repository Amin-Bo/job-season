package com.injob.back.service.impl;

import com.injob.back.dto.JobApplyDto;
import com.injob.back.mapper.JobApplyMapper;
import com.injob.back.mapper.JobOfferMapper;
import com.injob.back.model.JobApply;
import com.injob.back.model.JobOffer;
import com.injob.back.repository.JobApplyRepository;
import com.injob.back.repository.JobOfferRepository;
import com.injob.back.utils.AuthenticationUtils;
import com.nimbusds.jose.proc.SecurityContext;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import java.util.Collections;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

public class JobApplyServiceImplTest {
    @Mock
    private JobOfferRepository jobOfferRepository;

    @Mock
    private JobApplyRepository jobApplyRepository;

    @Mock
    private JobApplyMapper jobApplyMapper;

    @Mock
    private JobOfferMapper jobOfferMapper;

    @Mock
    private JobOfferServiceImpl jobOfferService;

    @Mock
    private AuthenticationUtils authenticationUtils;
    @Mock
    Authentication authentication;
    @InjectMocks
    private JobApplyServiceImpl jobApplyService;


    AutoCloseable closeable;
/*
    @BeforeEach
    public void setup() {
        closeable = openMocks(this);
        // Mock the behavior of AuthenticationUtils
        when(authenticationUtils.getEmailFromCurrentAuthentication()).thenReturn("test@example.com");

        // Set up a mock Authentication object in the SecurityContext
        Authentication authentication = mock(Authentication.class);
        SecurityContext securityContext = mock(SecurityContext.class);
        //when(securityContext.getAuthentication()).thenReturn(authentication);
        SecurityContextHolder.setContext((org.springframework.security.core.context.SecurityContext) securityContext);

    }

    @AfterEach
    void afterEach() throws Exception {
        // Clean all mocks
        closeable.close();
    }

    @Test
    void testAddJobApply() {
        // Setup your test data
        Long jobOfferId = 1L;

        //when(authenticationUtils.getEmailFromCurrentAuthentication()).thenReturn("test@example.com");

        // Call the service method
        JobApplyDto result = jobApplyService.addJobApply(jobOfferId);

        // Verify that the repository methods were called
        verify(jobOfferRepository, times(1)).findById(jobOfferId);
        verify(jobApplyRepository, times(1)).existsByJobOfferIdAndEmail(jobOfferId, "test@example.com");
        verify(jobApplyRepository, times(1)).save(any(JobApply.class));

        // Add your assertions based on the expected result and the actual result
        // For example, assertNotNull, assertEquals, etc.
    }
    /*
 */
}
