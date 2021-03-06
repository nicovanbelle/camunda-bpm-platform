/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.camunda.bpm.engine.test.history;

import org.camunda.bpm.engine.ProcessEngineException;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

/**
 * @author Roman Smirnov
 *
 */
public class SecondFailingDelegate implements JavaDelegate {

  public static final String SECOND_EXCEPTION_MESSAGE = "Second expected exception.";

  public void execute(DelegateExecution execution) throws Exception {
    Boolean fail = (Boolean) execution.getVariable("secondFail");

    if (fail == null || fail == true) {
      throw new ProcessEngineException(SECOND_EXCEPTION_MESSAGE);
    }
  }

}
