# letter-combination

## SpringBoot Web project

### When project started, could test by postman or run test cases.

Post Request : localhost:8080/letters/combinations

Request body (Json):

```
{
  "inputs": [3, 4]
}
```


Response (Json):

```
{
    "code": 0,
    "msg": "Success",
    "data": "dg dh di eg eh ei fg fh fi "
}

```


### Core algorithm ：Depth-First-Search


```
com.test.lettercombination.beans.DigitLettersList


private void doGetCombination(DigitLettersList.Node currentNode, String combinationLetter) {

    // If has next, compose current letter and keep search.
    if (currentNode.hasNext()) {
        if (currentNode.hasLetters()) {
            for (String letter : currentNode.letters) {
                doGetCombination(currentNode.getNext(), combinationLetter + letter);
            }
        } else {
            doGetCombination(currentNode.getNext(), combinationLetter);
        }
    }
    // If has not next, compose all letters, add to letterCombinationList then return.
    else {
        if (currentNode.hasLetters()) {
            for (String letter : currentNode.letters) {
                letterCombinationList.add(combinationLetter + letter);
            }
        } else {
            letterCombinationList.add(combinationLetter);
        }
    }
}

```
