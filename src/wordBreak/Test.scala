package wordBreak

/**
  * Created by yiyitan on 4/13/2016.
  */
object Test  {
    def main(args: Array[String]) {
        val ob = new WordBreakII()
        var testList = List[String]()
        testList  = testList :+ "hello"
        testList = testList :+ "why"
        println(testList)
        var s = "catsanddog"
        var wordDict = Set("cat", "cats" , "and", "sand", "dog")
        ob.wordBreak(s, wordDict)
    }
}
