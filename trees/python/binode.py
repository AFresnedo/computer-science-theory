class BinaryNode:

    def __init__(self, val = None, left = None, right = None):
        if not isinstance(left, BinaryNode) and left is not None:
            raise TypeError('left link should be a BinaryNode type')
        if not isinstance(right, BinaryNode) and right is not None:
            raise TypeError('right link should be a BinaryNode type')
        self.val = val
        self.left = left
        self.right = right

    def __str__(self):
        if self.left == None and self.right == None:
            return 'A childless node holding: {}'.format(self.val)
        elif self.right == None:
            return ('A node holding: {}, with a left child holding: '
                    '{}'.format(self.val, self.left.val))
        elif self.left == None:
            return ('A node holding: {}, with a right child holding: '
                    '{}'.format(self.val, self.right.val))
        else:
            return ('A node holding: {}, with a left child holding: {}, '
                    'and a right child holding: {}'.format(self.val,
                        self.left.val, self.right.val))

firstNode = BinaryNode(0, None, None)

secondNode = BinaryNode()

firstNode.val = 3

print(firstNode)

firstNode.right = BinaryNode(4, None, None)

print(firstNode)

firstNode.left = BinaryNode('hello', None, None)

print(firstNode)

firstNode.right = None

print(firstNode)
