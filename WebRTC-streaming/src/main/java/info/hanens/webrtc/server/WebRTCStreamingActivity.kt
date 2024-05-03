package info.hanens.webrtc.server

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import io.antmedia.webrtcandroidframework.api.IWebRTCClient
import org.webrtc.SurfaceViewRenderer


class WebRTCStreamingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.webrtc_streaming)

        val webRTCClient: IWebRTCClient = IWebRTCClient.builder()
            .setActivity(this)
            .setLocalVideoRenderer(findViewById<SurfaceViewRenderer>(R.id.full_screen_renderer))
            .setServerUrl("wss://test.antmedia.io:5443/WebRTCAppEE/websocket")
            .build()
        webRTCClient.publish("stream1")
    }
}