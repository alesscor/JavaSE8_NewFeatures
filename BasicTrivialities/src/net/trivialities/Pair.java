package net.trivialities;
/***
 * Implementation taken from http://stackoverflow.com/a/521235/3802741
 * by Paul Brinkley
 * @author Alessandro
 *
 * @param <L>
 * @param <R>
 */
final public class Pair<L,R> {

	  private final L left;
	  private final R right;

	  public Pair(L left, R right) {
	    this.left = left;
	    this.right = right;
	  }

	  public L getLeft() { return left; }
	  public R getRight() { return right; }

	  @Override
	  public int hashCode() { return left.hashCode() ^ right.hashCode(); }

	  @Override
	  public boolean equals(Object o) {
	    if (!(o instanceof Pair)) return false;
	    @SuppressWarnings("unchecked")
		Pair<L, R> pairObject = (Pair<L, R>) o;
	    return this.left.equals(pairObject.getLeft()) &&
	           this.right.equals(pairObject.getRight());
	  }

	}