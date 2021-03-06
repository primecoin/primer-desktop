/*
 *
 *  Copyright 2014 http://Bither.net
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 * /
 */

package org.primer.utils;

import org.primer.primerj.PrimerjSettings;
import org.primer.primerj.utils.Utils;

/**
 * Created by nn on 15/5/4.
 */
public class LogUtil {
    public static void printlnOut(String str) {
        if (!PrimerjSettings.LOG_DEBUG) {
            return;
        }
        if (Utils.isEmpty(str)) {
            return;
        }
        System.out.println(str);
    }

    public static void printlnError(String str) {
        if (!PrimerjSettings.LOG_DEBUG) {
            return;
        }
        if (Utils.isEmpty(str)) {
            return;
        }
        System.err.println(str);
    }
}
