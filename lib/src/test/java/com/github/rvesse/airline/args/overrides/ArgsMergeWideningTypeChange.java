package com.github.rvesse.airline.args.overrides;

import com.github.rvesse.airline.annotations.Command;
import com.github.rvesse.airline.annotations.Option;

@Command(name = "ArgsMergeWideningTypeChange")
public class ArgsMergeWideningTypeChange extends ArgsMergeTypeParent {

    /**
     * This is an illegal override as it involves a widening type conversion
     */
    @Option(name = "--test", arity = 1, override = true)
    public A test;
}
