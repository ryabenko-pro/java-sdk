package com.elarian.model;

public final class GetDigits implements VoiceAction {
    public Say say = null;
    public Play play = null;
    public long timeout;
    public String finishOnKey = "#";
    public int numDigits;

    public GetDigits(Say say) {
        this.say = say;
    }

    public GetDigits(Play play) {
        this.play = play;
    }
}
