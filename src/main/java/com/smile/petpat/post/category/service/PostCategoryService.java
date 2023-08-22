package com.smile.petpat.post.category.service;

import com.smile.petpat.post.category.domain.CategoryGroup;
import com.smile.petpat.post.category.dto.PostCategoryDto;

import java.util.List;

import static com.smile.petpat.post.category.dto.PostCategoryInfo.*;
import static com.smile.petpat.post.category.dto.PostCategoryDto.*;

public interface PostCategoryService {
    List<CategoryGroup> getCategoryGroup(String postTypeDescription);
    List<PetCategoryRes> getPetCategory(Long categoryGroup);
    List<TradeCategoryRes> getTradeCategory(Long categoryGroup);
    List<TradeCategoryDetailRes> getTradeCategoryDetail(Long tradeCategory);
    List<TradeCategoryResponse> getTradeCategoryAndCnt(Long tradeCategoryId);

    List<PostCategoryDto.RehomingCategoryResponse> getRehomingCategoryAndCnt(Long categoryGroupId);
}
