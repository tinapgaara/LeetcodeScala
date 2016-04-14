package wordBreak

/**
  * Created by yiyitan on 4/13/2016.
  *
  * 140. Word Break II
  */
/*
*
* Given a string s and a dictionary of words dict,
* add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].
* */
class WordBreakII {
  def wordBreak(s: String, wordDict: Set[String]) : List[String] = {
      val wordLen = s.length()
      var dp: Array[Set[String]] = new Array[Set[String]](wordLen + 1)
      dp(0) = Set[String]()
      dp = generateDp(s, wordDict, 0, dp)
      var initResult = List[String]()
      var rs = generateResult(dp, initResult, dp.length - 1)
      println(rs)
      return rs
  }

  def generateDp(s: String, wordDict:Set[String], i: Int, dp : Array[Set[String]]) : Array[Set[String]] = {
      var returnDp = dp
      if (i < dp.length - 1) {
          wordDict.foreach((word: String) => {
              val wordLen = word.length()
              if ( (i + wordLen <= s.length) && (word.equals(s.substring(i, i + wordLen))) ) {
                  var nextIndex = i + wordLen
                  if (nextIndex < returnDp.length) {
                    var nextWordDict = wordDict - word
                    if (returnDp(nextIndex) == null) {
                      returnDp(nextIndex) = Set[String]()
                    }
                    returnDp(nextIndex) += word
                    returnDp = generateDp(s, nextWordDict, nextIndex, returnDp)
                  }
              }
          })
      }
      returnDp
  }

  def generateResult(dp : Array[Set[String]], result : List[String], i :Int) : List[String] = {
      var set = dp(i)
      var newResult = List[String]()
      var eachResult = List[String]()
      if (i > 0) {
        set.foreach((word: String) => {
          if (result.nonEmpty) {
            result.foreach((phrase: String) => {
              eachResult = List[String]() :+ (word + " " + phrase)
            })
          }
          else if (result.isEmpty) {
            eachResult = List[String]() :+ word
          }

          var nextResult = generateResult(dp, eachResult, i - word.length)
          for (phrase <- nextResult) {
            newResult = newResult :+ phrase
          }
        })
        return newResult
      }
      return result
  }


}
