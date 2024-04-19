package defpackage;

import android.media.AudioAttributes;
import android.media.MediaMetadata;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import defpackage.d;
import defpackage.g;
import java.util.List;
/* compiled from: MediaControllerCompatApi21.java */
/* renamed from: h  reason: default package */
/* loaded from: classes.dex */
public class h<T extends g> extends MediaController.Callback {
    public final T a;

    public h(T t) {
        this.a = t;
    }

    @Override // android.media.session.MediaController.Callback
    public void onAudioInfoChanged(MediaController.PlaybackInfo playbackInfo) {
        T t = this.a;
        playbackInfo.getPlaybackType();
        AudioAttributes audioAttributes = playbackInfo.getAudioAttributes();
        if ((audioAttributes.getFlags() & 1) != 1 && (audioAttributes.getFlags() & 4) != 4) {
            switch (audioAttributes.getUsage()) {
            }
        }
        playbackInfo.getVolumeControl();
        playbackInfo.getMaxVolume();
        playbackInfo.getCurrentVolume();
        d dVar = ((d.a) t).a.get();
        if (dVar != null) {
            dVar.a();
        }
    }

    @Override // android.media.session.MediaController.Callback
    public void onExtrasChanged(Bundle bundle) {
        a.a(bundle);
        d dVar = ((d.a) this.a).a.get();
        if (dVar != null) {
            dVar.b();
        }
    }

    @Override // android.media.session.MediaController.Callback
    public void onMetadataChanged(MediaMetadata mediaMetadata) {
        d dVar = ((d.a) this.a).a.get();
        if (dVar != null) {
            MediaMetadataCompat.a(mediaMetadata);
            dVar.c();
        }
    }

    @Override // android.media.session.MediaController.Callback
    public void onPlaybackStateChanged(PlaybackState playbackState) {
        d dVar = ((d.a) this.a).a.get();
        if (dVar == null || dVar.c != null) {
            return;
        }
        PlaybackStateCompat.a(playbackState);
        dVar.d();
    }

    @Override // android.media.session.MediaController.Callback
    public void onQueueChanged(List<MediaSession.QueueItem> list) {
        d dVar = ((d.a) this.a).a.get();
        if (dVar != null) {
            MediaSessionCompat.QueueItem.a(list);
            dVar.e();
        }
    }

    @Override // android.media.session.MediaController.Callback
    public void onQueueTitleChanged(CharSequence charSequence) {
        d dVar = ((d.a) this.a).a.get();
        if (dVar != null) {
            dVar.f();
        }
    }

    @Override // android.media.session.MediaController.Callback
    public void onSessionDestroyed() {
        d dVar = ((d.a) this.a).a.get();
        if (dVar != null) {
            dVar.g();
        }
    }

    @Override // android.media.session.MediaController.Callback
    public void onSessionEvent(String str, Bundle bundle) {
        a.a(bundle);
        d dVar = ((d.a) this.a).a.get();
        if (dVar != null) {
            if (dVar.c != null) {
                int i = Build.VERSION.SDK_INT;
            }
            dVar.h();
        }
    }
}
