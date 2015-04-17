package gex.serling.utils

import spock.lang.Specification

/**
 * Created by Tsunllly on 4/17/15.
 */
class MapUtilsSpec extends Specification {


  def 'putValueAt should work for empty maps'(){
    given:
      Map emptyMap = [:]
      String path = "one.two.three"
      String value = "value"

    when:
      def result = MapUtils.putValueAt(emptyMap, path, value)

    then:
      result
      result == [
        one : [
          two: [
            three: value
          ]
        ]
      ]
  }

  def 'putValueAt should work for not empty maps'(){
    given:
      Map emptyMap = [
        key1: 'value1'
      ]
      String path = "one.two.three"
      String value = "value"

    when:
      def result = MapUtils.putValueAt(emptyMap, path, value)

    then:
      result
      result == [
        key1: 'value1',
        one : [
          two: [
            three: value
          ]
        ]
      ]
  }

  def 'putValueAt overrides value'(){
    given:
    Map emptyMap =[
      one : [
        two: [
          three: 'originalValue'
        ]
      ]
    ]
    String path = "one.two.three"
    String value = "modifiedValue"

    when:
    def result = MapUtils.putValueAt(emptyMap, path, value)

    then:
    result
    result == [
      one : [
        two: [
          three: 'modifiedValue'
        ]
      ]
    ]
  }

}
