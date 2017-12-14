Feature: we can check for a given string and calculate the numbers in the string

  Scenario: calculate on a given string
     Given we pass the value "12E5"
      when we calulate the result
      then we should have an output of "1200000.0"