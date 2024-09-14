import org.springframework.util.StringUtils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Created by ashish on 28/06/19.
 */
public class DetectLoop {
    public static void main(String[] args) {
        String test="eyJraWQiOiJhc3dfb2MxX2o0eGQiLCJhbGciOiJSUzI1NiJ9.eyJ0Z3QiOiJhbGxfc3ZjIiwic3ViIjoib2NpZDEudXNlci5vYzEuLmFhYWFhYWFhcm9jdGl6d25kdzV0Y3gyNnE1NmJuY2I0b2hqc21wNm9weDRwaG96bXdkdWRpNnpyYW9oYSIsImNoYWluIjoiIiwidGd0X25hbWUiOiJhbGxfc3ZjIiwidGd0cyI6IltcImFsbF9zdmNcIl0iLCJvd24iOiJvY2lkMS50ZW5hbmN5Lm9jMS4uYWFhYWFhYWE0bmo2bzVqdDNxcnR5NzdlYXB2YXRpaXdqeGt1NXd3dGV0NmZyd3BlZ2xxbXNiY2Yzd3JxIiwiaXNzIjoiYXV0aFNlcnZpY2Uub3JhY2xlLmNvbSIsInB0eXBlIjoidXNlciIsInRndF9uYW1lcyI6IltcImFsbF9zdmNcIl0iLCJhdWQiOiJvY2kiLCJwc3R5cGUiOiJuYXR2IiwidHR5cGUiOiJvYm8iLCJleHAiOjE2NzEyNTk2NTgsImlhdCI6MTY3MTE3MzI1OCwianRpIjoiZjEwOWQyZGEtOWIyNC00NDRmLWFmMmItODU4YWQ3ZTViZWRhIiwidGVuYW50Ijoib2NpZDEudGVuYW5jeS5vYzEuLmFhYWFhYWFhZ2tiemdnNmxwenJmNDd4enk0cmpveGc0ZGU2bmNmaXEycm5jbWppdWp2eTJoamd4dnppcSIsIm5hbWUtY2hhaW4iOiIifQ.bPiY-7TyC9DVJ5Ee9fo-9NXMOfmF38bcPZrwK3FUfuE2a0GGaQF6kjfqummK-6fCjjSOj2-xWL71rGnkBGsVeNst0tvkR8cIc5OW8TZXXY8_ekMXAgVB7E_v9HbgjHBblMqqZ4rK6sON4ngmiTUpbpBSbzhUBMTAKPFTsfcYlpFN5fdYgR9jTsSlPj-URmdluFtXXmQ32AVNZWTz-Xd-rsrjJulMjoJZAil8N5EIztXhJe_Pt-Fs2Z5RAMaCmSSL2rhotOnU9_L6RvNp02sCIgU3pQ5TT9FRa5DhU5_rH6FCRiEzKwSFKfW7ScdPj_cI8kYQckIxCBfc4xWNXEVsDQ";
        final String[] tokenParts = test.split("\\.");
        final String tokenJsonPayload =
                new String(Base64.getDecoder().decode(tokenParts[1]), StandardCharsets.UTF_8);

        System.out.println(tokenJsonPayload);
    }
}
