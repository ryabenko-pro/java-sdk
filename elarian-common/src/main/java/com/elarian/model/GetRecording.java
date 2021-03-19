package com.elarian.model;

public final class GetRecording implements VoiceAction {
    public Say say = null;
    public Play play = null;
    public long timeout;
    public long maxLength;
    public String finishOnKey;
    public boolean playBeep = true;
    public boolean trimSilence = true;

    public GetRecording(Say say) {
        this.say = say;
    }
    public GetRecording(Play play) {
        this.play = play;
    }
}
