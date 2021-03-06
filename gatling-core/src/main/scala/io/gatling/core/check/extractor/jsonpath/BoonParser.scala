/**
 * Copyright 2011-2014 eBusiness Information, Groupe Excilys (www.ebusinessinformation.fr)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 		http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.gatling.core.check.extractor.jsonpath

import java.io.{ InputStream, InputStreamReader }
import java.nio.charset.Charset

import org.boon.json.implementation.{ JsonFastParser, JsonParserUsingCharacterSource }

object BoonParser extends JsonParser {

  def parse(bytes: Array[Byte], charset: Charset) = {
    val parser = new JsonFastParser(false, false, true, false)
    parser.setCharset(charset)
    parser.parse(bytes)
  }

  def parse(string: String) = {
    val parser = new JsonFastParser(false, false, true, false)
    parser.parse(string)
  }

  def parse(stream: InputStream, charset: Charset) = {
    val parser = new JsonParserUsingCharacterSource
    parser.parse(new InputStreamReader(stream, charset))
  }
}
