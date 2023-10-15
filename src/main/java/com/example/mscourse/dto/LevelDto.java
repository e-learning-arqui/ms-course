package com.example.mscourse.dto;

public class LevelDto {

        private Long levelId;
        private String levelName;

        public LevelDto() {}

        public LevelDto(Long levelId, String levelName) {
            this.levelId = levelId;
            this.levelName = levelName;
        }

        // getters setters y to string
        public Long getLevelId() {return levelId;}

        public void setLevelId(Long levelId) {this.levelId = levelId;}

        public String getLevelName() {return levelName;}

        public void setLevelName(String levelName) {this.levelName = levelName;}

        @Override
        public String toString() {
            return "Level{" +
                    "levelId=" + levelId +
                    ", levelName='" + levelName + '\'' +
                    '}';
        }

}
