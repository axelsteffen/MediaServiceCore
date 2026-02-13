package com.liskovsoft.youtubeapi.videoinfo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.liskovsoft.googlecommon.common.converters.jsonpath.converter.JsonPathConverterFactory;
import com.liskovsoft.googlecommon.common.converters.jsonpath.converter.JsonPathResponseBodyConverter;
import com.liskovsoft.sharedutils.TestHelpers;
import com.liskovsoft.youtubeapi.videoinfo.models.VideoInfo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowLog;

import java.io.InputStream;

@RunWith(RobolectricTestRunner.class)
public class VideoInfoCategoryTest {

    @Before
    public void setUp() {
        System.setProperty("javax.net.ssl.trustStoreType", "JKS");
        ShadowLog.stream = System.out;
    }

    @Test
    public void testThatGetVideoInfoParsesCategory() throws Exception {
        try (InputStream stream = TestHelpers.openResource("video_info/get_video_info.json")) {
            assertNotNull("Test resource exists", stream);

            JsonPathConverterFactory factory = JsonPathConverterFactory.create();
            JsonPathResponseBodyConverter<VideoInfo> converter =
                    (JsonPathResponseBodyConverter<VideoInfo>) factory
                            .responseBodyConverter(VideoInfo.class, null, null);
            VideoInfo videoInfo = converter.convert(stream);

            assertNotNull("VideoInfo parsed", videoInfo);
            assertEquals("Category is News & Politics (URL-encoded)",
                    "News+&+Politics", videoInfo.getCategory());
        }
    }
}
