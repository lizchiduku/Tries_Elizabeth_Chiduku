import java.util.Collections;
import java.util.List;

public class Trie {
	public Node root;

	public Trie() {
		this.root = new Node();
	}

	public void insertWord(String word) {
		// gets the root node;
		Node currentNode = this.root;

		// iterates over every character in the word
		for (int i = 0; i < word.length(); i++) {
			// currentLetter is just the character / letter at the iteration
			Character currentLetter = word.charAt(i);
			// ask if the current letter is in the map of the current node
			Node child = currentNode.children.get(currentLetter);
			if (child == null) {
				child = new Node();
				currentNode.children.put(currentLetter, child);
			}

			currentNode = child;
		}
		currentNode.isCompleteWord = true;
	}

	// Returns a boolean whether the prefix is in the trie or not.
	public boolean isPrefixValid(String prefix) {
		List words = null;
		int pos = Collections.binarySearch(words, prefix) ;
        if (pos >= 0) {
            // The prefix is a word. Check the following word, because we are looking 
            // for words that are longer than the prefix
            if (pos +1 < words.size()) {
                String nextWord = (String) words.get(pos+1);
                return nextWord.startsWith(prefix);
            }
            return false;
        }
        pos = -(pos+1);
        // The prefix is not a word. Check where it would be inserted and get the next word.
        // If it starts with prefix, return true.
        if (pos == words.size()) {
            return false;
        }
        String nextWord = (String) words.get(pos);
        return nextWord.startsWith(prefix);
    }

    //Returns a boolean whether the word is in the trie or not.
	public boolean contains(String word) {
        List<String> words = null;
		@SuppressWarnings("unchecked")
		int pos = Collections.binarySearch(words, word);
        return pos >= 0;
    }
}