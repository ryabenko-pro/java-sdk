package com.elarian.model;

public final class VoiceCallInput {
    public VoiceCallDirection direction;
    public VoiceCallStatus status;
    public VoiceCallHangupCause hangupCause;
    public long startedAt;
    public String dtmfDigits;
    public String recordingUrl;
    public VoiceCallDialInput dialData;
    public VoiceCallQueueInput queueData;
}
