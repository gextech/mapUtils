package gex.serling.utils

/**
 * Created by Tsunllly on 4/17/15.
 */
class MapUtils {

  final static String TOKENIZER = "."

  static Map putValueAt(Map map, String path, Object value){
    def result = [:] + map


    List elements = path.tokenize(TOKENIZER)

    if( elements.size == 1 ){
      def key = elements.first()
      result[key] = value
    }
    else if( elements.size > 1 ){
      def key = elements.remove(0)

      def traversed = map.get(key) ?: [:]

      if(!traversed instanceof Map){
        traversed = [:]
      }

      result[key] = traversed + putValueAt(traversed, elements.join(TOKENIZER), value)
    }

    result
  }




}
