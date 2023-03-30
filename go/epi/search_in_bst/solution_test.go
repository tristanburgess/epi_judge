package search_in_bst_test

import (
	"fmt"
	"os"
	"path/filepath"
	"reflect"
	"testing"

	"github.com/stefantds/csvdecoder"

	"go-epi-judge/data_structures/tree"
	. "go-epi-judge/epi/search_in_bst"
	utils "go-epi-judge/test_utils"
)

type solutionFunc = func(*tree.BSTNode, int) *tree.BSTNode

var solutions = []solutionFunc{
	SearchBST,
}

func TestSearchBST(t *testing.T) {
	testFileName := filepath.Join(cfg.TestDataFolder, "epi/search_in_bst.tsv")
	file, err := os.Open(testFileName)
	if err != nil {
		t.Fatalf("could not open file %s: %v", testFileName, err)
	}
	defer file.Close()

	type TestCase struct {
		Tree           tree.BSTNodeDecoder
		Key            int
		ExpectedResult int
		Details        string
	}

	parser, err := csvdecoder.NewWithConfig(file, csvdecoder.Config{Comma: '\t', IgnoreHeaders: true})
	if err != nil {
		t.Fatalf("could not parse file %s: %s", testFileName, err)
	}

	for i := 0; parser.Next(); i++ {
		tc := TestCase{}
		if err := parser.Scan(
			&tc.Tree,
			&tc.Key,
			&tc.ExpectedResult,
			&tc.Details,
		); err != nil {
			t.Fatal(err)
		}

		for _, s := range solutions {
			t.Run(fmt.Sprintf("Test Case %d %v", i, utils.GetFuncName(s)), func(t *testing.T) {
				if cfg.RunParallelTests {
					t.Parallel()
				}
				result := searchBSTWrapper(s, tc.Tree.Value, tc.Key)
				if !reflect.DeepEqual(result, tc.ExpectedResult) {
					t.Errorf("\ngot:\n%v\nwant:\n%v\ntest case:\n%+v\n", result, tc.ExpectedResult, tc)
				}
			})
		}
	}
	if err = parser.Err(); err != nil {
		t.Fatalf("parsing error: %s", err)
	}
}

func searchBSTWrapper(solution solutionFunc, node *tree.BSTNode, key int) int {
	node = tree.DeepCopyBSTNode(node)
	if result := solution(node, key); result != nil {
		return result.Data
	}
	return -1
}
