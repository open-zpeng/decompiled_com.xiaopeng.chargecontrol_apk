package com.xiaopeng.lib.framework.moduleinterface.carcontroller;
/* loaded from: classes.dex */
public interface IRadioController extends ILifeCycle {
    public static final int BAND_AM = 3;
    public static final int BAND_FM = 0;
    public static final int TEF663x_PCHANNEL = 256;
    public static final int X_SOUND_BASS = 7;
    public static final int X_SOUND_CLASSICAL = 2;
    public static final int X_SOUND_CUSTOMIZE = 10;
    public static final int X_SOUND_DEFAULT = 0;
    public static final int X_SOUND_DYNAMIC = 8;
    public static final int X_SOUND_ELEGANT = 12;
    public static final int X_SOUND_HIFI = 11;
    public static final int X_SOUND_JAZZ = 4;
    public static final int X_SOUND_POPULAR = 5;
    public static final int X_SOUND_PUREVOICE = 9;
    public static final int X_SOUND_ROCK = 1;
    public static final int X_SOUND_SURROUND = 6;
    public static final int X_SOUND_VOICE = 3;

    /* loaded from: classes.dex */
    public static class AudioDspInfoEventMsg extends AbstractEventMsg<String> {
    }

    /* loaded from: classes.dex */
    public static class RadioInfoEventMsg extends AbstractEventMsg<String> {
    }

    void enableAudioDpsInfoCallback();

    String getAudioDspInfo();

    int[] getAudioMode();

    int getRadioBand();

    int[] getRadioFrequency();

    String getRadioInfo();

    int getRadioVolumeAutoFocus();

    int[] getRadioVolumePercent();

    boolean getTunerPowerStatus();

    int getXSoundType();

    void setAudioBalanceFader(int value1, int value2);

    void setAudioGEQParams(int band, int frequency, int liftCurve, int gain);

    void setExhibitionModeVolume(int percent);

    void setFmVolume(int channel, int volume);

    void setMainAudioMode(int item, int value);

    void setPowerOffTuner();

    void setPowerOnTuner();

    void setRadioBand(int band);

    void setRadioFrequency(int band, int frequency);

    void setRadioSearchDown();

    void setRadioSearchUp();

    void setRadioVolumeAutoFocus(int percent);

    void setRadioVolumePercent(int channel, int vol);

    void setStartFullBandScan();

    void setStopFullBandScan();

    void setXSoundType(int type);
}
