/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */
/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
void dfs(struct TreeNode* node, char* path, int pathLen, char** result, int* returnSize ){
    if(node == NULL)
        return;
    
    int len =sprintf(path + pathLen, "%d", node->val);
    pathLen +=len;

    if(node->left == NULL && node->right == NULL){
        path[pathLen] = '\0';
        result[*returnSize] = strdup(path);
        (*returnSize)++;
        return;
    }

    sprintf(path + pathLen, "->");
    pathLen +=2;

    dfs(node->left, path, pathLen, result, returnSize);
    dfs(node->right, path,  pathLen, result, returnSize);
}



char** binaryTreePaths(struct TreeNode* root, int* returnSize) {
    char** result =  malloc(100* sizeof(char*));
    *returnSize =0;

    char path[1000];
    dfs(root, path, 0, result , returnSize );

    return result;
}