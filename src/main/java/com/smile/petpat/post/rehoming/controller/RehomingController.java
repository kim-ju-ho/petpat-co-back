package com.smile.petpat.post.rehoming.controller;

import com.smile.petpat.common.response.SuccessResponse;
import com.smile.petpat.post.rehoming.domain.RehomingCommand;
import com.smile.petpat.post.rehoming.dto.RehomingPagingDto;
import com.smile.petpat.post.rehoming.service.RehomingServiceImpl;
import com.smile.petpat.user.service.UserDetailsImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@Tag(name = "RehomingController", description = "분양 API 입니다.")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/rehoming")
public class RehomingController {

    private final RehomingServiceImpl rehomingService;

    /**
     * 분양 게시물 등록
     * @return 성공 시 200 Success 반환
     */
    @PreAuthorize("hasRole('USER')")
    @Operation(summary = "분양게시글 등록", description = "분양게시글 등록")
    @RequestMapping(value = "",method = RequestMethod.POST)
    public SuccessResponse registerRehoming(@AuthenticationPrincipal UserDetailsImpl userDetails,
                                  @ModelAttribute @Valid RehomingCommand rehomingDto) {
        RehomingCommand rehomingCommand = rehomingDto.toCommand();
        rehomingService.registerRehoming(userDetails.getUsername(), rehomingCommand);
        return SuccessResponse.noDataSuccess("OK");
    }

    /**
     * 분양 게시물 목록 조회
     * @return 성공 시 200 Success 및 분양 게시물 목록 반환
     */
    @PreAuthorize("hasRole('USER')")
    @Operation(summary = "분양게시글 목록 조회", description = "분양게시글 목록 조회")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public SuccessResponse listRehoming(@AuthenticationPrincipal User userDetails,
                                        @PageableDefault Pageable pageable) {
        RehomingPagingDto rehomingInfos;
        rehomingInfos = rehomingService.listRehomingForMember(userDetails.getUsername(), pageable);
        return SuccessResponse.success(rehomingInfos, "OK");
    }

    @PreAuthorize("hasRole('GUEST')")
    @Operation(summary = "분양게시글 목록 조회", description = "분양게시글 목록 조회")
    @RequestMapping(value = "/public", method = RequestMethod.GET)
    public ResponseEntity listRehomingPublic(@PageableDefault Pageable pageable) {
        RehomingPagingDto rehomingInfos;
        rehomingInfos = rehomingService.listRehoming(pageable);
        return ResponseEntity.ok(rehomingInfos);
    }

    /**
     * 분양 게시물 상세 조회
     * @return 성공 시 200 Success 및 해당 게시물 반환
     */
    @PreAuthorize("hasRole('USER')")
    @Operation(summary = "분양게시글 상세 조회", description = "분양게시글 상세 조회")
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public SuccessResponse detail(@RequestParam Long postId,
                                  @AuthenticationPrincipal User userDetails) {
        return SuccessResponse.success(rehomingService.detailRehomingForMember(postId, userDetails.getUsername()), "OK");
    }

    @PreAuthorize("hasRole('GUEST')")
    @Operation(summary = "분양게시글 상세 조회", description = "분양게시글 상세 조회")
    @RequestMapping(value = "/public/detail", method = RequestMethod.GET)
    public SuccessResponse detailPublic(@RequestParam Long postId) {
        return SuccessResponse.success(rehomingService.detailRehoming(postId), "OK");
    }

    /**
     * 분양 게시물 수정
     * @return 성공 시 200 Success 및 수정된 게시물 반환
     */
    @PreAuthorize("hasRole('USER')")
    @Operation(summary = "분양게시물 수정", description = "분양게시물 수정")
    @RequestMapping(value = "", method = RequestMethod.PUT)
    public SuccessResponse updateRehoming(@AuthenticationPrincipal User userDetails,
                                          @RequestParam Long postId,
                                          @ModelAttribute @Valid RehomingCommand rehomingDto) {
        RehomingCommand rehomingCommand = rehomingDto.toCommand();
        return SuccessResponse.success(rehomingService.updateRehoming(userDetails.getUsername(), postId, rehomingCommand), "OK");
    }

    /**
     * 분양 게시물 삭제
     * @return 성공 시 200 Success 반환
     */
    @PreAuthorize("hasRole('USER')")
    @Operation(summary = "분양게시물 삭제", description = "분양 게시물 삭제")
    @RequestMapping(value = "",method = RequestMethod.DELETE)
    public SuccessResponse deleteRehoming(@AuthenticationPrincipal User userDetails,
                                          @RequestParam Long postId) {
        rehomingService.deleteRehoming(userDetails.getUsername(), postId);
        return SuccessResponse.noDataSuccess("OK");
    }

    /**
     * 분양 게시물 상태값 변경
     * @return 성공 시 200 Success 및 게시물 타입 및 번호 반환
     */
    @PreAuthorize("hasRole('USER')")
    @Operation(summary = "분양게시물 상태변경 [분양 중]", description= "분양게시물 상태변경 [분양 중]")
    @RequestMapping(value = "/statusFinding", method = RequestMethod.POST)
    public SuccessResponse updateStatusFinding(@AuthenticationPrincipal User userDetails,
                                                @RequestParam Long postId) {
        rehomingService.updateStatusFinding(userDetails.getUsername(), postId);
        return SuccessResponse.noDataSuccess("OK");
    }

    @PreAuthorize("hasRole('USER')")
    @Operation(summary = "분양게시물 상태변경 [예약 중]", description= "분양게시물 상태변경 [예약 중]")
    @RequestMapping(value = "/statusReserved", method = RequestMethod.POST)
    public SuccessResponse updateStatusReserved(@AuthenticationPrincipal User userDetails,
                                                @RequestParam Long postId) {
        rehomingService.updateStatusReserved(userDetails.getUsername(), postId);
        return SuccessResponse.noDataSuccess("OK");
    }

    @PreAuthorize("hasRole('USER')")
    @Operation(summary = "분양게시물 상태변경 [예약 완료]", description= "분양게시물 상태변경 [예약 완료]")
    @RequestMapping(value = "/statusMatched", method = RequestMethod.POST)
    public SuccessResponse updateStatusMatched(@AuthenticationPrincipal User userDetails,
                                               @RequestParam Long postId) {
        rehomingService.updateStatusMatched(userDetails.getUsername(), postId);
        return SuccessResponse.noDataSuccess("OK");
    }

    @PreAuthorize("hasRole('USER')")
    @Operation(summary = "분양게시물 카테고리별 목록 조회", description = "분양게시물 카테고리별 목록 조회")
    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public ResponseEntity<?> getCategoryList(@AuthenticationPrincipal User userDetails,
                                             @RequestParam("categoryId") Long categoryId, @RequestParam("typeId") Long typeId,
                                             @PageableDefault Pageable pageable) {
        RehomingPagingDto rehomingPagingDto;
        rehomingPagingDto = rehomingService.getCategoryListForMember(userDetails.getUsername(), categoryId, typeId, pageable);
        return ResponseEntity.ok(rehomingPagingDto);

    }

    @PreAuthorize("hasRole('GUEST')")
    @Operation(summary = "분양게시물 카테고리별 목록 조회", description = "분양게시물 카테고리별 목록 조회")
    @RequestMapping(value = "/public/category", method = RequestMethod.GET)
    public ResponseEntity<?> getCategoryListPublic(@RequestParam("categoryId") Long categoryId, @RequestParam("typeId") Long typeId,
                                             @PageableDefault Pageable pageable) {
        RehomingPagingDto rehomingPagingDto;
        rehomingPagingDto = rehomingService.getCategoryList(categoryId, typeId, pageable);
        return ResponseEntity.ok(rehomingPagingDto);

    }
}
