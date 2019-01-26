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
        self.check_integrity()
        if self.left == None and self.right == None:
            return 'A childless node holding: {}'.format(self.val)
        elif self.right == None:
            return ('A BinaryNode holding: {}, with a left child holding: '
                    '{}'.format(self.val, self.left.val))
        elif self.left == None:
            return ('A BinaryNode holding: {}, with a right child holding: '
                    '{}'.format(self.val, self.right.val))
        else:
            return ('A BinaryNode holding: {}, with a left child holding: {}, '
                    'and a right child holding: {}'.format(self.val,
                        self.left.val, self.right.val))

    # Does not consider presence of child nodes
    def __bool__(self):
        return False if self.val == None else True

    # FIXME one liner is too long, how to break line?
    def __eq__(self, operand):
        return True if hasattr(operand, 'value') and self.value == operand.value else False

    # FIXME type checking is not conventional in python, check behavior instead
    def check_integrity(self):
        if self.left != None and not isinstance(self.left, BinaryNode):
            raise TypeError('left child must be a BinaryNode or None')
        if self.right != None and not isinstance(self.right, BinaryNode):
            raise TypeError('right child must be a BinaryNode or None')
