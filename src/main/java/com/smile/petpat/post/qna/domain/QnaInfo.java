package com.smile.petpat.post.qna.domain;

import com.smile.petpat.post.category.domain.PostType;
import com.smile.petpat.post.common.CalculateTime;
import com.smile.petpat.post.common.status.PostStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

public class QnaInfo {

    @Getter
    @ToString
    public static class QnaList{
        private Long qnaId;
        private String nickname;
        private String title;
        private String imagePath;
        private PostType postType;
        private int viewCnt;

        private String createAt;

        public QnaList(){
           
        }

        public QnaList(Long qnaId, String nickname, String title, String imagePath, PostType postType, int viewCnt, String createAt) {
            this.qnaId = qnaId;
            this.nickname = nickname;
            this.title = title;
            this.imagePath = imagePath;
            this.postType = postType;
            this.viewCnt = viewCnt;
            this.createAt = createAt;
        }

        public QnaList(Long qnaId, String nickname, String title,
                       String imagePath, PostType postType,
                       int viewCnt, LocalDateTime createAt) {
            this.qnaId = qnaId;
            this.nickname = nickname;
            this.title = title;
            this.imagePath = imagePath;
            this.postType = postType;
            this.viewCnt = viewCnt;
            this.createAt = CalculateTime.dateformatForPost(createAt);
        }

    }
//
//    @Getter
//    @ToString
//    @AllArgsConstructor
//    public static class QnaDetail{
//        private Long qnaId;
//        private Long userId;
//        private String nickname;
//        private String title;
//        private String content;
//        private List<String> imageList;
//        private PostType postType;
//        private int viewCnt;
//        private String createAt;
//
//        public QnaDetail(){
//
//        }
//
//        public QnaDetail(Long qnaId, Long userId, String nickname, String title, String content, List<String> imageList, PostType postType,
//                         LocalDateTime createAt
//        ) {
//            this.qnaId = qnaId;
//            this.userId = userId;
//            this.nickname = nickname;
//            this.title = title;
//            this.content = content;
//            this.imageList = imageList;
//            this.postType = postType;
//            this.viewCnt = viewCnt;
//            this.createAt = CalculateTime.dateformatForPost(createAt);
//        }
//
//        public QnaDetail(Long qnaId, Long userId, String nickname, String title, String content, PostType postType, Long isLiked, Long isBookmarked, int viewCnt,
//                           Long likeCnt, Long bookmarkCnt, String qnaCategoryDetailName,PostStatus status,LocalDateTime createAt) {
//            this.qnaId = qnaId;
//            this.userId = userId;
//            this.nickname = nickname;
//            this.title = title;
//            this.content = content;
//            this.postType = postType;
//            this.viewCnt = viewCnt;
//            this.createAt = CalculateTime.dateformatForPost(createAt);
//        }
//
//        public QnaDetail(QnaInfo.QnaDetail qnaDetail, List<String> imageList) {
//            this.qnaId = qnaDetail.qnaId;
//            this.userId = qnaDetail.userId;
//            this.nickname = qnaDetail.nickname;
//            this.title = qnaDetail.title;
//            this.content = qnaDetail.content;
//            this.imageList = imageList;
//            this.postType = qnaDetail.postType;
//            this.isLiked = qnaDetail.isLiked;
//            this.isBookmarked = qnaDetail.isBookmarked;
//            this.viewCnt = qnaDetail.viewCnt;
//            this.likeCnt = qnaDetail.likeCnt;
//            this.bookmarkCnt = qnaDetail.bookmarkCnt;
//            this.qnaCategoryDetailName = qnaDetail.qnaCategoryDetailName;
//            this.status=qnaDetail.status;
//            this.createAt = qnaDetail.createAt;
//        }
//
//
//
//
//    }
//
//    public static  Boolean booleanChk(Long chkValue) {
//        return chkValue == 0?false : true;
//    }


}
