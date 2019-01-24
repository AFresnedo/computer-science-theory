class BinaryNode:
  def __init__(self, val = None, left = None, right = None):
    if not isinstance(left, BinaryNode) and left is not None:
        raise TypeError('left link should be a BinaryNode type')
    if not isinstance(right, BinaryNode) and right is not None:
        raise TypeError('right link should be a BinaryNode type')
    self.val = val
    self.left = left
    self.right = right

firstNode = BinaryNode(0, None, None)

secondNode = BinaryNode()
