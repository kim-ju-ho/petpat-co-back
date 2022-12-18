package com.smile.petpat.post.rehoming.dto;

import com.smile.petpat.post.category.domain.PostType;
import com.smile.petpat.post.rehoming.domain.Rehoming;
import com.smile.petpat.post.rehoming.domain.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class RehomingResDto {
    private Long rehomingId;
    private Long userId;
    private String nickname;
    private List<String> rehomingImg;
    private String title;
    private String description;
    private int viewCnt;
    private String petName;
    private String petAge;
    private String category;
    private String type;
    private String gender;
    private String region;
    private Long price;
    private Status status;
    private PostType postType;
    private List<String> tagList;

    private boolean isLiked;
    private boolean isBookmarked;
    private int likeCnt;
    private int bookmarkCnt;

    public RehomingResDto(Rehoming rehoming, List<String> rehomingImg, boolean isLiked, boolean isBookmarked, int likeCnt, int bookmarkCnt) {
        this.rehomingId = rehoming.getRehomingId();
        this.userId = rehoming.getUser().getId();
        this.nickname = rehoming.getUser().getNickname();
        this.title = rehoming.getTitle();
        this.description = rehoming.getDescription();
        this.petName = rehoming.getPetName();
        this.petAge = rehoming.getPetAge();
        this.category = rehoming.getCategory();
        this.type = rehoming.getType();
        this.gender = rehoming.getGender();
        this.region = rehoming.getRegion();
        this.price = rehoming.getPrice();
        this.status = rehoming.getStatus();
        this.rehomingImg = rehomingImg;
        // this.tagList = tagList;
        this.postType = rehoming.getPostType();
        this.isLiked = isLiked;
        this.isBookmarked = isBookmarked;
        this.likeCnt = likeCnt;
        this.bookmarkCnt = bookmarkCnt;
    }
}
