//package algo;
//
//// The following is an example Java implementation that converts an AWS Secret
//// Access Key to an Amazon SES SMTP password. Before you run the program, put
//// the AWS Secret Access Key of the IAM user into an environment variable called
//// AWS_SECRET_ACCESS_KEY. The output of the program is the SMTP password. That
//// password, along with the SMTP username (which is the same as the AWS Access
//// Key ID) are the user's Amazon SES SMTP credentials.
//
//import javax.crypto.Mac;
//import javax.crypto.spec.SecretKeySpec;
//import javax.xml.bind.DatatypeConverter;
//
// class SesSmtpCredentialGenerator {
//    private static final String KEY_ENV_VARIABLE = "AWS_SECRET_ACCESS_KEY"; // Put your AWS secret access key in this environment variable.
//    private static final String MESSAGE = "SendRawEmail"; // Used to generate the HMAC signature. Do not modify.
//    private static final byte VERSION =  0x02; // Version number. Do not modify.
//
//    public static void main(String[] args) {
//
//        // Get the AWS secret access key from environment variable AWS_SECRET_ACCESS_KEY.
//        //String key = System.getenv(KEY_ENV_VARIABLE);
//        String key="wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY";
//        if (key == null) {
//            System.out.println("Error: Cannot find environment variable AWS_SECRET_ACCESS_KEY.");
//            System.exit(0);
//        }
//
//        // Create an HMAC-SHA256 key from the raw bytes of the AWS secret access key.
//        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "HmacSHA256");
//
//        try {
//            // Get an HMAC-SHA256 Mac instance and initialize it with the AWS secret access key.
//            Mac mac = Mac.getInstance("HmacSHA256");
//            mac.init(secretKey);
//
//            // Compute the HMAC signature on the input data bytes.
//            byte[] rawSignature = mac.doFinal(MESSAGE.getBytes());
//
//            // Prepend the version number to the signature.
//            byte[] rawSignatureWithVersion = new byte[rawSignature.length + 1];
//            byte[] versionArray = {VERSION};
//            System.arraycopy(versionArray, 0, rawSignatureWithVersion, 0, 1);
//            System.arraycopy(rawSignature, 0, rawSignatureWithVersion, 1, rawSignature.length);
//
//            // To get the final SMTP password, convert the HMAC signature to base 64.
//            String smtpPassword = DatatypeConverter.printBase64Binary(rawSignatureWithVersion);
//            System.out.println(smtpPassword);
//        }
//        catch (Exception ex) {
//            System.out.println("Error generating SMTP password: " + ex.getMessage());
//        }
//    }
//}
