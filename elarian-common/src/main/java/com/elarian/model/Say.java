package com.elarian.model;

public final class Say implements VoiceAction {
    public String text;
    public boolean playBeep = false;
    public TextToSpeechVoice voice = TextToSpeechVoice.FEMALE;

    public Say(String text) {
        this.text = text;
    }

    public Say(String text, boolean playBeep, TextToSpeechVoice voice) {
        this.text = text;
        this.playBeep = playBeep;
        this.voice = voice;
    }
}

