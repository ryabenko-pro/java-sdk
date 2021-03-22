package com.elarian.model;

public final class GetRecording implements VoiceAction {
    public Say say = null;
    public Play play = null;
    public long timeout;
    public long maxLength;
    public String finishOnKey;
    public boolean playBeep = true;
    public boolean trimSilence = true;

    public GetRecording(Say say, long timeout, long maxLength, String finishOnKey, boolean playBeep, boolean trimSilence) {
        this.say = say;
        this.timeout = timeout;
        this.maxLength = maxLength;
        this.finishOnKey = finishOnKey;
        this.playBeep = playBeep;
        this.trimSilence = trimSilence;
    }
    public GetRecording(Play play, long timeout, long maxLength, String finishOnKey, boolean playBeep, boolean trimSilence) {
        this.play = play;
        this.timeout = timeout;
        this.maxLength = maxLength;
        this.finishOnKey = finishOnKey;
        this.playBeep = playBeep;
        this.trimSilence = trimSilence;
    }
}
