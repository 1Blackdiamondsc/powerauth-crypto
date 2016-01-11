/**
 * Copyright 2015 Lime - HighTech Solutions s.r.o.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.getlime.security.powerauth.lib.util.http;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.getlime.security.powerauth.lib.enums.PowerAuthSignatureTypes;

public class PowerAuthHttpHeader {
	
	public static final String ACTIVATION_ID = "pa_activation_id";
	public static final String APPLICATION_ID = "pa_application_id";
	public static final String SIGNATURE = "pa_signature";
	public static final String SIGNATURE_TYPE = "pa_signature_type";
	public static final String NONCE = "pa_nonce";
	public static final String VERSION = "pa_version";
	
	private static final String POWERAUTH_PREFIX = "PowerAuth ";

	public static Map<String, String> parsePowerAuthSignatureHTTPHeader(String xPowerAuthSignatureHeader) {
		xPowerAuthSignatureHeader = xPowerAuthSignatureHeader.trim();
		if (!xPowerAuthSignatureHeader.startsWith(POWERAUTH_PREFIX)) {
			return null;
		}
		xPowerAuthSignatureHeader = xPowerAuthSignatureHeader.substring(POWERAUTH_PREFIX.length());
		
		// Parse the key / value pairs
		Map<String, String> result = new HashMap<>();
		Pattern p = Pattern.compile("(\\w+)=\"*((?<=\")[^\"]+(?=\")|([^\\s]+)),*\"*");
		Matcher m = p.matcher(xPowerAuthSignatureHeader);
		while(m.find()){
		    result.put(m.group(1), m.group(2));
		}

		return result;
	}
	
	private static String headerField(String key, String value) {
		return key + "=\"" + value + "\"";
	}
	
	/**
	 * Generate a valid PowerAuth Authorization header based on provided parameters.
	 * @param activationId An ID of an activation.
	 * @param applicationId An ID of an application.
	 * @param nonce Random nonce.
	 * @param signatureType Signature type.
	 * @param signature Signature.
	 * @param version PowerAuth protocol version.
	 * @return Value to be used in <code>X-PowerAuth-Authorization</code> HTTP header.
	 */
	public static String getPowerAuthSignatureHTTPHeader(String activationId, String applicationId, String nonce, PowerAuthSignatureTypes signatureType, String signature, String version) {
		String result = POWERAUTH_PREFIX
				+ headerField(ACTIVATION_ID, activationId) + ", "
				+ headerField(APPLICATION_ID, applicationId) + ", "
				+ headerField(NONCE, nonce) + ", "
				+ headerField(SIGNATURE_TYPE, signatureType.toString()) + ", "
				+ headerField(SIGNATURE, signature) + ", "
				+ headerField(VERSION, version);
		return result;
	}

}
