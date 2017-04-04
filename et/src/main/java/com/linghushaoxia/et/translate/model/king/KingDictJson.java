/**
 * Copyright 2016-2017 linghushaoxia
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.linghushaoxia.et.translate.model.king;

import java.util.List;

/**功能说明：
 * @author:linghushaoxia
 * @time:2017年4月3日上午12:59:50
 * @version:1.0
 * 为中国孱弱的技术，
 * 撑起一片自立自强的天空
 */
public class KingDictJson {
    private String wordName;
    private List<Symbol> symbols;
    public String getWordName() {
        return wordName;
    }
    public void setWordName(String wordName) {
        this.wordName = wordName;
    }
    public List<Symbol> getSymbols() {
        return symbols;
    }
    public void setSymbols(List<Symbol> symbols) {
        this.symbols = symbols;
    }
}

/**
* 现实就是实现理想的过程。
* 
*/