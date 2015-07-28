/**
 * Copyright (C) 2010 the original author or authors.
 * See the notice.md file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.rvesse.airline.parser.errors;

import com.github.rvesse.airline.utils.AirlineUtils;

import java.util.List;

/**
 * Exception that is thrown when an unrecognized command is supplied
 *
 */
public class ParseCommandUnrecognizedException extends ParseRestrictionViolatedException
{
    private static final long serialVersionUID = 7580940207857781141L;
    
    private final List<String> unparsedInput;

    public ParseCommandUnrecognizedException(List<String> unparsedInput)
    {
        super("Command '%s' not recognized", unparsedInput.get(0));
        this.unparsedInput = AirlineUtils.unmodifiableListCopy(unparsedInput);
    }

    public List<String> getUnparsedInput()
    {
        return unparsedInput;
    }
}
