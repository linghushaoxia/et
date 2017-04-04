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
 */package com.linghushaoxia.et.translate.model.king;

import java.util.List;

/**功能说明：
 * @author:linghushaoxia
 * @time:2017年4月3日上午1:19:17
 * @version:1.0
 * 为中国孱弱的技术，
 * 撑起一片自立自强的天空
 */
public class Symbol {
    private String wordSymbol;
    private String symbolMp3;
    private List<Part> parts;
    private String phAmMp3;
    private String phEnMp3;
    private String phTtsMp3;
    private String phOther;
    public String getWordSymbol() {
        return wordSymbol;
    }
    public void setWordSymbol(String wordSymbol) {
        this.wordSymbol = wordSymbol;
    }
    public String getSymbolMp3() {
        return symbolMp3;
    }
    public void setSymbolMp3(String symbolMp3) {
        this.symbolMp3 = symbolMp3;
    }
    public List<Part> getParts() {
        return parts;
    }
    public void setParts(List<Part> parts) {
        this.parts = parts;
    }
    public String getPhAmMp3() {
        return phAmMp3;
    }
    public void setPhAmMp3(String phAmMp3) {
        this.phAmMp3 = phAmMp3;
    }
    public String getPhEnMp3() {
        return phEnMp3;
    }
    public void setPhEnMp3(String phEnMp3) {
        this.phEnMp3 = phEnMp3;
    }
    public String getPhTtsMp3() {
        return phTtsMp3;
    }
    public void setPhTtsMp3(String phTtsMp3) {
        this.phTtsMp3 = phTtsMp3;
    }
    public String getPhOther() {
        return phOther;
    }
    public void setPhOther(String phOther) {
        this.phOther = phOther;
    }
}

/**
* 现实就是实现理想的过程。
* 
*/