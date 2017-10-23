package com.hust.bigdataplatform.model;

public class ExperimentFile {
    private String experimentId;

    private String fileId;

    public String getExperimentId() {
        return experimentId;
    }

    public void setExperimentId(String experimentId) {
        this.experimentId = experimentId == null ? null : experimentId.trim();
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId == null ? null : fileId.trim();
    }
}