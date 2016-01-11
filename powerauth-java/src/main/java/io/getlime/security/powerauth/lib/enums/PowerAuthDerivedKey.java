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
package io.getlime.security.powerauth.lib.enums;

import java.util.HashMap;
import java.util.Map;

public enum PowerAuthDerivedKey {
	
	SIGNATURE_POSSESSION(1),
	SIGNATURE_KNOWLEDGE(2),
	SIGNATURE_BIOMETRY(3),
	TRANSPORT(1000),
	ENCRYPTED_VAULT(2000);
	
	private long index;

    private static Map<Long, PowerAuthDerivedKey> map = new HashMap<>();

    static {
        for (PowerAuthDerivedKey derivedKey : PowerAuthDerivedKey.values()) {
            map.put(derivedKey.index, derivedKey);
        }
    }

    private PowerAuthDerivedKey(final long index) {
    	this.index = index;
    }

    public static PowerAuthDerivedKey valueOf(long index) {
        return map.get(index);
    }
    
    public long getIndex() {
    	return index;
    }

}